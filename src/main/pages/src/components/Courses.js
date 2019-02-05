import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import CoursesPage from '../containers/CoursesPage';
import ToolbarView from "../shared/ToolbarView";
import withStyles from "@material-ui/core/styles/withStyles";
import Typography from "@material-ui/core/Typography";


const styles = theme => ({
    root: {
        display: 'flex',
    },

    toolbar: {
        display: 'flex',
        justifyContent: 'flex-end',
        padding: '0 8px',
        ...theme.mixins.toolbar,
    },

    title: {
        fontSize: '20px',
        fontWeight: 'bold',
        marginBottom: theme.spacing.unit * 3,
    },

    content: {
        flexGrow: 1,
        padding: theme.spacing.unit * 3,
    },
});

class Courses extends React.Component {
    render(){
        const { classes } = this.props;

        return (
            <div className={classes.root}>
                <CssBaseline />
                <ToolbarView/>
                <main className={classes.content}>
                    <div className={classes.toolbar} />
                    <Typography className={classes.title}>
                        Courses
                    </Typography>
                    <CoursesPage/>
                </main>
            </div>
        );
    }

}
export default withStyles(styles) (Courses);