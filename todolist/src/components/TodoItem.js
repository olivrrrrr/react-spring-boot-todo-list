import React, {useState, useEffect} from 'react';

function TodoItem(props) {

    const [todoItem, setTodoItem] = useState(props.data); 

    useEffect(()=>{
        fetch(`http://localhost:8080/api/v1/todolist/${todoItem.id}`,{
        method: 'PUT' , 
        headers: {
            "content-type" : "application/json",
        },
        body: JSON.stringify(todoItem)
         }).then(resp=>
        resp.json()).then((data) =>{
        setTodoItem(data);
        });
    }, [todoItem])

    function handleOnClick(){
        setTodoItem({...todoItem, complete: !todoItem.complete}); 
    } 

    function handleDelete(e){
    
        fetch(`http://localhost:8080/api/v1/todolist/${todoItem.id}`,{
          method: 'DELETE' , 
          headers: {
              "content-type" : "application/json",
          },
          body : JSON.stringify(todoItem)
          }).then(console.log("deleted"))
          e.preventDefault();
    }

    return (
        <div >
            <input type="checkbox" 
            checked={todoItem.complete} 
            onChange={handleOnClick} /> {" "}
            {todoItem.complete ? 
            (<span style={{textDecoration : "line-through"}}>{todoItem.description}</span>) 
            : (<span>{todoItem.description}</span>)}
            <button onClick={handleDelete}>delete</button>
        </div> 
    )
}

export default TodoItem