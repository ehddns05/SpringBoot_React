package com.web.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.demo.model.Board;
import com.web.demo.model.FileVo;
import com.web.demo.repository.BoardRepository;
import com.web.demo.repository.FileRepository;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardService {

    @Autowired
    BoardRepository repo;

    @Autowired
    FileRepository filerepo;

    @Autowired(required=true) 
    private HttpServletRequest request;

    @Autowired(required=true) 
    private HttpServletResponse response;


    @Transactional
    public void save_board(Board board, MultipartFile file) {
        // setLocaltime
        board.setDate(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(board);
        System.out.println(board);
        if (file != null) {
            upload_File(file);
        }
    }

    public List<Board> findAll() {
        return (List<Board>) repo.findAll();
    }

    public Board getBoardDetail(int boardnum) {
        System.out.println(boardnum);
        Optional<Board> boardEntityWrapper = repo.findByBoardnum(boardnum);

        return boardEntityWrapper.get();
    }

    public void filedownload(int boardnum) {
        System.out.println("filedownload");
        System.out.println(request.getCharacterEncoding());
        FileVo fileVo = filerepo.findByBoardnum(boardnum);

        try{
            String fileUrl = fileVo.getFileurl();
            fileUrl += "/";
            String savePath = fileUrl;
            String fileName = fileVo.getFilename();
            
            //실제 내보낼 파일명 
            String oriFileName = fileVo.getFileOriname();
            InputStream in = null;
            OutputStream os = null;
            File file = null;
            boolean skip = false;
            String client = "";
            
            //파일을 읽어 스트림에 담기  
            try{
                file = new File(savePath, fileName);
                in = new FileInputStream(file);
            } catch (FileNotFoundException fe) {
                skip = true;
            }
            
            client = request.getHeader("User-Agent");
            
            //파일 다운로드 헤더 지정 
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Description", "JSP Generated Data");
            
            if (!skip) {
                // IE
                if (client.indexOf("MSIE") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                    // IE 11 이상.
                } else if (client.indexOf("Trident") != -1) {
                    response.setHeader("Content-Disposition", "attachment; filename=\""
                            + URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                } else {
                    // 한글 파일명 처리
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                    response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
                }
                response.setHeader("Content-Length", "" + file.length());
                os = response.getOutputStream();
                byte b[] = new byte[(int) file.length()];
                int leng = 0;
                while ((leng = in.read(b)) > 0) {
                    os.write(b, 0, leng);
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
            }
            in.close();
            os.close();
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
        }
    }

    public void upload_File(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
        File destinationFile;
        String destinationFileName;
        String fileUrl = "C:\\Download\\temp\\";

        // do {
        destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
        destinationFile = new File(fileUrl + destinationFileName);
        // } while (destinationFile.exists());
        try {
            destinationFile.getParentFile().mkdirs();
            file.transferTo(destinationFile);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<Board> boardList = findAll();
        Board board = boardList.get(boardList.size()-1);

        FileVo uploadFile = new FileVo();
        uploadFile.setBoardnum(board.getBoardnum());
        uploadFile.setFileOriname(fileName);
        uploadFile.setFilename(destinationFileName);
        uploadFile.setFileurl(fileUrl);
        filerepo.save(uploadFile);

    }
}