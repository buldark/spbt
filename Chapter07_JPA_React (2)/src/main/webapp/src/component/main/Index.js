
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { BrowserRouter, Link } from 'react-router-dom';
import List from '../user/List';

const Index = () => {
   /* 
     return(
   const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/hello')
        .then(res => setHello(res.data))//res.data로부터 바꾼다
        .catch(error => console.log(error))
    }, [])

    return (
        <div>
            데이터 : { hello }
        </div>
    );
 };

export default Index;
    */

    return(
        <div>
            <h3>***메인 화면***</h3>
            <hr />           
        <p><Link to="/user/writeForm">입력</Link></p>
        <p><Link to="/user/list">출력</Link></p> 
        <p><Link to="/user/update">수정</Link></p> 
        <p><Link to="/user/deleteForm">삭제</Link></p>
        <p><Link to="/user/uploadForm">이미지 업로드</Link></p>                                    

        </div>
                
             
            
                // <p><Link to="/user/updateForm">수정</Link></p>
                //<p><Link to="/user/deleteForm">삭제</Link></p>
               // <p><Link to="/user/uploadForm">파일 등록</Link></p> 
           

          
               // <Route path="/user/list" element={<List />} />
               // <Route path="/user/updateForm" element={<UpdateForm />} />
               // <Route path="/user/deleteForm" element={<DeleteForm />} />
              //  <Route path="/user/uploadForm" element={<UploadForm />} />
         

               
            
       
    );
};

export default Index;



