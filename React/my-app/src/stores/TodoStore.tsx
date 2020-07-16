import { observable, action, computed, autorun } from 'mobx';

export default class TodoStore {
    
    @observable
    todolist: string[] = [];

    @action
    addWork = (work: string) => {
        this.todolist.map(work => work);
    }

    @computed
    get showlog(){
        this.todolist.push('0');
        return console.log("computed")
    }

    // autorun = () => {
    //     this.todolist.push('0');    
    //     console.log("autorun");
    // }
}