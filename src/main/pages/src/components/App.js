import React from 'react';
import Login from './Login';
import SignUp from './SignUp';
import Courses from './Courses';
import ToolBar from '../shared/ToolbarView';

import { HashRouter, Route } from 'react-router-dom';

class App extends React.Component {
    render() {
        return (
            <HashRouter>
                <div>
                    <Route exact path='/' component={Login} />
                    <Route path="/SignUp" component={SignUp} />
                    <Route path="/ToolBar" component={ToolBar}/>
                    <Route path="/Courses" component={Courses}/>
                </div>
            </HashRouter>
        );
    }
}

export default App;