import TodoItem from './components/todoItem';
import {useEffect, useState} from 'react';
import uuid from 'react-uuid';


function App() {

  const [todoList, setTodoList] = useState(0);
  const [change, setChange] = useState("");

  useEffect(()=>{
    if(!todoList){
         fetch("http://localhost:8080/api/v1/todolist", {
          method: 'GET' , 
          headers: {
              "content-type" : "application/json"
          }}).then(resp=>
         resp.json()).then((data) =>{
         setTodoList(data);
         });
        }
    }, [todoList]);

    function handleChange(e){
         setChange(e.target.value);
        }

    function handleDeleteTodoItem(item){
        const updatedTodoItems = todoList.filter(aTodoItem => aTodoItem !== item.id);
        setTodoList([...updatedTodoItems]); 
    }


   function handleSubmit(e){
       const todoItem = {description: change, complete: false};
        
        fetch(`http://localhost:8080/api/v1/todolist/`,{
          method: 'POST' , 
          headers: {
              "content-type" : "application/json"
          },
          body: JSON.stringify(todoItem)
          }).then(()=>{
            setTodoList([...todoList, todoItem])})
        e.preventDefault();
  }


  return (
    <div> 
       <form onSubmit={handleSubmit}>  
          <input type="text" value={change} onChange={handleChange}/>
          <input type="submit" value="Submit" />
       </form>
      {todoList ? todoList.map(todoItem =>{
          return (
            <TodoItem key={todoItem.id} data={todoItem} emitDeleteTodoItem={handleDeleteTodoItem}/>
          )
    }) : "loading..." }
  </div>
    
  );
}

export default App;
