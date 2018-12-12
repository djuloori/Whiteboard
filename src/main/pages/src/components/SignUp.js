import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/Login.css';
import SignUpPage from '../containers/SignUpPage';


class SignUp extends React.Component {
    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(username,password,type) {
        console.log(type);
        this.postData(this.getContextPath() + `/app/Users/Signup`, {
            "username": username,
            "password": password,
            "usertype": type
        }).then(response => {
            if (response.ok) {
                response.text().then((data) => {
                    if(data == 'Success'){
                        this.props.history.push('/');
                    }});
            }
        });
    }

    postData(url = ``, data = {}) {
        return fetch(url, {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json; charset=utf-8",
            },
        })
    }

    getContextPath() {
        return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    }

    render(){
        return (
           <div>
               <SignUpPage onSubmit={this.handleClick}/>
           </div>
        );
    }

}
export default SignUp;