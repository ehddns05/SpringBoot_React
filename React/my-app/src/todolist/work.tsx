import React from 'react';
import { decorate, observable, action } from 'mobx';
import { observer, inject } from 'mobx-react';
import TodoStore from '../stores/TodoStore';


@inject('todostore')
@observer
class Work extends React.Component{

    render(){

        const { todostore }: any = this.props;
        console.log("autorun");

        return(
            <div>
                <ul>
                 {todostore.showlog}
                 {todostore.todolist[0]}
                </ul>
            </div>
        )

    }
}

export default Work;