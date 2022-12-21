import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Index from './component/main/Index';
import DeleteForm from './component/user/DeleteForm';
import List from './component/user/List';
import UpdateForm from './component/user/UpdateForm';
import UploadForm from './component/user/UploadForm';

import WriteForm from './component/user/WriteForm';

const App = () => {
  return (
    <div>
      <BrowserRouter>
        <>  
            {/* 화면에 보이는 영역 */}
            <Routes>
            <Route path='/' element={<Index />} />
            <Route path="/user/writeForm" element={<WriteForm />} /> 
            <Route path="/user/list" element={ <List /> } />  
            <Route path="/user/update" element={ <UpdateForm /> } />  
            <Route path="/user/deleteForm" element={ <DeleteForm/> } />  
            <Route path="/user/uploadForm" element={ <UploadForm/> } />  
          
          
            </Routes>
        </>
      </BrowserRouter>      
    </div>
  );
};

export default App;

/*
Rest API                             axios
                                     =>axios의 request method

POST : 데이터 등록 및 전송             axios.post()
GET : 데이터 조회                      axios.get()
PUT : 데이터 수정                       axios.put()  
DELETE : 데어터 삭제                  axios.delete()
*/