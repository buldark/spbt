import axios from 'axios';
import React, { useEffect, useState } from 'react';

const List = () => {
    const [list, setList] = useState([]);
    const [keyword, setKeyword] =useState('')
    const [searchOption ,setSearchOption] =useState('name')

    useEffect(() => {
        axios.get('http://localhost:8080/user/getUserList')//포트 다르니가 풀주소
            .then((res) => {//주소가서 res 받아오기
                setList(res.data)})//setList에 담기            
            .catch((error) => console.log(error));


    }, []);

    const onSearch =( e) =>{
        e.preventDefault()
        axios.get('http://localhost:8080/user/search',{
           params : {
                searchOption :searchOption, 
                keyword : keyword
            }
        })
             .then(res => setList(res.data))
             .catch(error=> console.log(error))
    }
    
    return (
        <div>
            <table border="1" >
                <thead>
                    <tr>
                   
                        <th width="150">이름</th>
                        <th width="150">아이디</th>
                        <th width="150">비밀번호</th>
                    </tr> 
                </thead>
                <tbody>
                    {
                        list.map((item) => {
                            return (
                                <tr key={item.id}>
                                    <td align='center'>{item.name}</td>
                                    <td align='center'>{item.id}</td>
                                    <td align='center'>{item.pwd}</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
        
            </table>
            <br/><br/>
            <div style ={{width : '450px',textAlign:'center',margin : '50px'}}>
                    <form id='searchForm'>
                        <select  name='searchOption'>
                            <option value='name'>이름</option>
                            <option vlaue ='id'>아이디</option>
                        </select>
                        <input type='text' id='keyword' value={keyword} onChange={e => setKeyword(e.target.value)} /> &nbsp;
                        <button  onClick={onSearch}>검색</button>
                    </form>
            </div>
        </div>
    );
};

export default List;