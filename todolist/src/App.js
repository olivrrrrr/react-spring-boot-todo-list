import TodoItem from './components/todoItem';
import {useEffect, useState} from 'react';

function App() {

  const [todoList, setTodoList] = useState(0);

  useEffect(()=>{
    if(!todoList){
         fetch("http://localhost:8080/api/v1/todolist").then(resp=>
         resp.json()).then((data) =>{
         console.log(data)
         setTodoList(data);
         });
        }
    });

 
  return (
    <div> {todoList ? todoList.map(todoItem =>{
          return <TodoItem  key={todoItem.id} data={todoItem}/>
    }) : "loading..." }
  </div>
    
  );
}

export default App;
