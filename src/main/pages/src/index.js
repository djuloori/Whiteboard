import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import Courses from './components/Courses';
import {BrowserRouter} from 'react-router-dom'


const root = document.getElementById('root');
root ? ReactDOM.render(<BrowserRouter><Courses/></BrowserRouter>, root) : false;