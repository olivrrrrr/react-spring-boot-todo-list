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

    return (
        <div >
            <input type="checkbox" 
            checked={todoItem.complete} 
            onChange={handleOnClick} /> {" "}
            <span>{todoItem.description}</span>
        </div> 
    )
}

export default TodoItem