import axios from 'axios';
import React, { useRef, useState } from 'react';

const UploadForm = () => {
    const imgRef = useRef()//html태그 요소 접근 가능 / 업데이트도  useRef사용가능 - trigger 메소드 대신해서
   
    const onCamera = (e) =>{
        imgRef.current.click() //  이렇게 쓰면 트리거 역활 대신 해줌!!  강제 이벤트 발생 
        //비록 카메라를 누르지만 input type="file" 태그의 imgRef때문에 카메라를 눌러도 input 태그 이벤트 발생
    }
   
    const [showImgSrc,setShowImgSrc] =useState('')
    const [uploadImgSrc,setUploadImgSrc] =useState('')
    const [file,setFile] =useState('')
    const readURL =(input) => {
        var reader = new FileReader();
        reader.readAsDataURL(input.files[0])

        reader.onload=(e) =>{
            console.log(input.files[0])
            setShowImgSrc(reader.result)
            setFile(input.files[0])
        }
    }

    const onUploadSubmit =() =>{
        var formData =new FormData()
        formData.append('img',file)
        axios.post('http://localhost:8080/user/upload2',formData,{
            headers : {
                'content-Type':`multipart/form-data` //이 뒷부분은 백팁
            }
        })
             .then( res => setUploadImgSrc(res.data))
             .catch(error => console.log(error))
    }
    return (
        <div>
          <img src={showImgSrc}width='300' height ='300' /> &ensp;
          <img src='../image/camera.svg' width='50' height='50' onClick={onCamera} alt='camera'/> {/*모든  시작점은 index.html 의 root쪽!! */}
          <input type='file' name = 'img' ref={imgRef} onChange={e =>readURL(e.target)} style={{visibility:'hidden'}}/> {/* 파일 선택 안보이게!!  대신 이제 카메라 누르면 이미지 올라가게 */}
            <br/>
            <button onClick={onUploadSubmit}>이미지 등록</button>
            <br/>
            <h4>이미지 등록후</h4>
            <img src={uploadImgSrc} width='200' height='200'/>
        </div>
    );
};

export default UploadForm;