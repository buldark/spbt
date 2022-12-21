import axios from 'axios';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import styles from '../../css/UpdateForm.module.css'

const UpdateForm = () => {

    const[form ,setForm] =useState({
        name : '',
        id : '',
        pwd : ''
    })
    const {name , id ,pwd} = form 
    
    const [searchId,setSearchId] =useState('')
    const [search,setSearch] =useState('')
    const [result ,setResult]=useState('')
    const [show , setShow] =useState(true)
    const [nameDiv ,setNameDiv] =useState('')
    const [pwdDiv,setPwdDiv] =useState('')
    
    const onSearch=() =>{
        axios.get(`http://localhost:8080/user/getUser?id=${searchId}`)
             .then(res => {
               res.data === null ? 
                    (setResult('찾고자 하는 아이디 없습니다') , setShow(true)) // 참 - ( , ) 이런식으로 연결  또는 이래처럼 || 연결연산자
                    :
                    setForm(res.data) || setResult('') || setShow(false) // 여기사 ||는 or 가 아니라 연결 연산자이다
             })
             .catch(error=> console.log(error))
    }

    
   
    const onInput=(e)=> {
        const {name,value}=e.target

        setForm({
            ...form,
            [name] : value
        })
    }
    const navigate = useNavigate()
    const onUpdateSubmit = (e) =>{
        e.preventDefault()//일단 submit막기

        var sw=1;
        if(!name){
            setNameDiv('이름을 입력하세요')
            sw = 0            
        }
     
        if(!pwd){
            setPwdDiv('비번를 입력하세요')
            sw = 0
        }

        //방법3
        if(sw === 1){
                axios.put('http://localhost:8080/user/update', null, {params:form})
                     .then(() =>{
                        alert("업데잍 성공.");
                        navigate("/user/list");
                     })
                     .catch(error => console.log(error))
            }
    }
    const onReset =(e) => {
        e.preventDefault()
        onSearch()

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
            <p>  수정할 아이디 : <input type='text' name='searchId' value={searchId} onChange={e =>setSearchId(e.target.value)}/>
                &emsp;
                <button onClick={onSearch}>검색</button>
            </p>
            <div id ='resultDiv'>{result}</div>
            
            <div id ='updateDiv' hidden={show} >
              <form  className={styles.UpdateForm} >
             
           
              <div>
               <p> 이름 : <input type='text'  name='name' value={name} onChange={onInput}/></p>
             </div>
             <div id='nameDiv' className={styles.div}>{nameDiv}</div>

             <div>
               <p> 아이디 : <input type='text' name='id' value={id} readOnly/></p>
             </div>
           

             <div>
               <p> 비밀번호 : <input type='password' name='pwd' value={pwd} onChange={onInput}/></p>
             </div>
             <div id='pwdDiv'>{pwdDiv}</div>
             
             <div>
                <p> 
                    <button onClick={onUpdateSubmit}>등록</button>
                    <button  onClick={onReset}>취소</button>
                </p>
             </div>
             
              </form>     
            </div>
         </div>

       

        
            
        </> 
      
    );
};

export default UpdateForm;