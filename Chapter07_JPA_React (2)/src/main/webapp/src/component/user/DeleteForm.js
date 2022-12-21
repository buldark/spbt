import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

const DeleteForm = () => {
    const [searchId,setSearchId] =useState('')
    const [search,setSearch] =useState('')
    const [result ,setResult]=useState('')
    const navigate = useNavigate()
    const onSearch=() =>{
        axios.get(`http://localhost:8080/user/getUser?id=${searchId}`)
             .then(res => {
               res.data === null ? 
                    setSearchId('')||setResult('찾고자 하는 아이디 없습니다') 
                    :
                    axios.delete(`http://localhost:8080/user/delete?id=${searchId}`)
                        .then(() =>{
                            alert("정보 삭제");
                            navigate("/user/list");
                        })
                        .catch(error=> console.log(error))
             })
             .catch(error=> console.log(error))
    }

    return (
        <>
              <h1>
                <Link to ='/'>
                    <img src='../image/img2.png' width='100' height='100' style={{cursor:'pointer'}}/>
                </Link>
             
            
        </h1>
        <hr/>

        <div> 
            <p>  삭제할  아이디 : <input type='text' name='searchId' value={searchId} onChange={e =>setSearchId(e.target.value)}/>
                &emsp;
                <button onClick={onSearch}>검색</button>
            </p>
            <div id ='resultDiv'>{result}</div>
            
        </div>
        </>
    );
};

export default DeleteForm;