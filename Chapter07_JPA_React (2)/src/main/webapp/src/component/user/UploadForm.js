import React from 'react';

const UploadForm = () => {
    return (
        <div>
          <form id="uploadForm">
              <img id="showImg" width="300" height="300"/>
              <img id="camera" src="../image/camera.svg" width="50" height="50" alt="카메라"/>
	          <input type="file" name="img" id="img"/>
	             <br/><br/>
	            <input type="button" id="uploadBtn" value="이미지 등록"/> 
	            <br/>
	            <h4>이미지 등록 후 </h4>
	            <div id="imgDiv"></div>
            </form>
        </div>
    );
};

export default UploadForm;