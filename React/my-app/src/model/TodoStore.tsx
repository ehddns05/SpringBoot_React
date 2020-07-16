import { observable, action } from 'mobx';

export default class TodoStore {
    
    @observable
    todolist: string[] = [];

    @action
    addWork = (work: string) => {
        this.todolist.map(work => work);
    }
}