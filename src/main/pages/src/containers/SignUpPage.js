import React from 'react';
import '../styles/AcountPageCustom.css';
import {NavLink} from "react-router-dom";
import Email from '@material-ui/icons/Email';
import Lock from '@material-ui/icons/Lock';

class SignUpPage extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: '',
            usertype:''
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(){
        this.props.onSubmit(this.state.username,this.state.password,this.state.usertype);
    }

    render(){
        return (
            <div className="container">
                <div className="d-flex justify-content-center title">
                    <h1>Whiteboard</h1>
                </div>
                <div className="card">
                    <div className="card-header">
                        <h3>Sign Up</h3>
                    </div>
                    <div className="card-body">
                        <form>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><Email className="email_icon"></Email></span>
                                </div>
                                <input type="text" className="form-control" placeholder="Email" onChange={(event) => this.setState({username:event.target.value})}/>

                            </div>

                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><Lock className="lock_icon"></Lock></span>
                                </div>
                                <input type="text" className="form-control" placeholder="Password" onChange={(event) => this.setState({password:event.target.value})}/>
                            </div>

                            <div className="row align-items-center type">
                                <div className="radio">
                                    <label><input type="radio" name="optradio" onChange={(event) => this.setState({usertype:'Professor'})}/>&nbsp;Professor</label>
                                </div>
                                <div className="radio">
                                    <label><input type="radio" name="optradio" onChange={(event) => this.setState({usertype:'Student'})}/>&nbsp;Student</label>
                                </div>
                            </div>
                            <div className="form-group">
                                <input type="submit" value="Register" onClick={this.handleChange} className="btn float-right register_btn"/>
                            </div>
                        </form>
                    </div>
                    <div className="card-footer">
                        <div className="d-flex justify-content-center links account-text">
                            Already have an account?&nbsp;<NavLink exact to = "/" className='login-link'>Login In</NavLink>
                        </div>
                    </div>
                </div>

            </div>
        );
    }

}
export default SignUpPage;