import TodoItem from './components/todoItem';
import {useEffect, useState} from 'react';

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
         console.log(data)
         setTodoList(data);
         });
        }
    });

    function handleChange(e){
         setChange(e.target.value);
        }

   function handleSubmit(e){
        
        const todoItem = {description: change, complete: false};
        console.log(todoItem); 

        fetch(`http://localhost:8080/api/v1/todolist/`,{
          method: 'POST' , 
          headers: {
              "content-type" : "application/json"
          },
          body : JSON.stringify(todoItem)
          }).then(console.log("new"))
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
          <div>
            <TodoItem  key={todoItem.id} data={todoItem}/>
          </div>
          )
    }) : "loading..." }
  </div>
    
  );
}

export default App;
