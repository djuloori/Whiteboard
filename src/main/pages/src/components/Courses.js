import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import CoursesPage from '../containers/CoursesPage';
import ToolbarView from "../shared/ToolbarView";
import withStyles from "@material-ui/core/styles/withStyles";
import Typography from "@material-ui/core/Typography";

class Courses extends React.Component {
    render(){
        return (
            <CoursesPage/>
        );
    }
}
export default Courses;