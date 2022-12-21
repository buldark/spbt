import axios from 'axios';
import React, { useState } from 'react';
import { Link, Navigate, useNavigate } from 'react-router-dom';
import styles from '../../css/WriteForm.module.css';
const WriteForm = () => {
    
   
    const[form ,setForm] =useState({
        name : '',
        id : '',
        pwd : ''
    })
    const {name , id ,pwd} = form 

    const [nameDiv ,setNameDiv] =useState('')
    const [idDiv ,setIdDiv] =useState(' ')
    const [pwdDiv,setPwdDiv] =useState('')

    const onInput=(e)=> {
        const {name,value}=e.target

        setForm({
            ...form,
            [name] : value
        })
    }
    const onWriteSubmit = (e) => {
        e.preventDefault()//일단 submit막기

        var sw=1;
        if(!name){
            setNameDiv('이름을 입력하세요')
            sw = 0            
        }
        if(!id){
            setIdDiv('아이디를 입력하세요')
            sw = 0
        }
        if(!pwd){
            setPwdDiv('비번를 입력하세요')
            sw = 0
        }

        
        //방법1
        // if(sw === 1){
        //     axios.post('http://localhost:8080/user/write',null,{
        //      params: {
        //         id : id,
        //         name :name,
        //         pwd : pwd
        //          }
        //     })
        //          .then(() =>{
        //             alert("회원가입을 축하합니다.");
        //             navigate("/user/list");
        //          })
        //          .catch(error => console.log(error))
        // }
        
        //방법2
        // if(sw === 1){
        //     axios.post('http://localhost:8080/user/write', null, {params:form})
        //          .then(() =>{
        //             alert("회원가입을 축하합니다.");
        //             navigate("/user/list");
        //          })
        //          .catch(error => console.log(error))
        // }
       
        
        
    }
   
    const checkId =() => { //등록할 때는 포스트 / 가져올 때는 겟?? 을 많이 씀 
        axios
            .get(`http://localhost:8080/user/isExistId?id=${id}`)
            .then(res=> {
                setIdDiv(res.data === 'non_exist' ? '사용가능' : '사용 불가능')//3항 연산자 사용

            })
            .catch(error => console.log(error))
    }
        const onReset =() =>{
            e.preventDefault()//일단 submit막기
            setForm({
                name : '',
                id : '',
                pwd : 'cle'
            })
        }
        const navigate = useNavigate()
    return (
        <>
        <h1>
                <Link to ='/'>
                    <img src='../image/img2.png' width='100' height='100' style={{cursor:'pointer'}}/>
                </Link>
                회원가입

            
        </h1>
        <hr/>
        <form  className={styles.WriteForm}>
            <div>
               <p> 이름 : <input type='text'  name='name' value={name} onChange={onInput}/></p>
             </div>
             <div id='nameDiv' className={styles.div}>{nameDiv}</div>

             <div>
               <p> 아이디 : <input type='text' name='id' value={id} onChange={onInput} onBlur={checkId}/></p>
             </div>
             <div id='idDiv'>{idDiv}</div>

             <div>
               <p> 비밀번호 : <input type='password' name='pwd' value={pwd} onChange={onInput}/></p>
             </div>
             <div id='pwdDiv'>{pwdDiv}</div>
             <div>
                <p> 
                    <button onClick={onWriteSubmit} >등록</button>
                    <button onClick={onReset}>취소</button>
                </p>
             </div>


        </form>
            
        </>
    );
};

export default WriteForm;