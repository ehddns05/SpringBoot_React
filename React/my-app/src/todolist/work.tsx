import React from 'react';
import { decorate, observable, action } from 'mobx';
import { observer } from 'mobx-react';

class Work extends React.Component{

    

    render(){
        return(
            <div>
                <form>

                <input type="text"/>
                <button onSubmit>input</button>
                </form>
                <ul></ul>
            </div>
        )

    }
}

export default Work;