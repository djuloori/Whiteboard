import React, { Component } from 'react';
import { Page } from 'react-pdf';
import { Document } from 'react-pdf/dist/entry.webpack';
import CssBaseline from "@material-ui/core/CssBaseline";
import withStyles from "@material-ui/core/styles/withStyles";
import PropTypes from "prop-types";
import ToolbarDoc from "../shared/ToolbarDoc";
import blueGrey from '@material-ui/core/colors/blueGrey';

const styles = theme => ({
    root: {
        display: 'flex',
        backgroundColor: blueGrey[300],
    },

    content: {
        flexGrow: 1,
        marginTop: theme.spacing.unit * 5,
        padding: theme.spacing.unit * 3,
    },

    margin: {
        float: 'right',
        margin: theme.spacing.unit,
        marginTop: theme.spacing.unit * 3,
    },

    textCss: {
        verticalAlign: '-10px',
        display: 'inline-block',

    },

    pageCss: {
        '&>canvas': {
            border: '1 solid red',
            margin: 'auto',
        }
    }

});

class ViewDoc extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            numPages: null,
            pageNumber: 1,
        }
    }

    onDocumentLoadSuccess = ({ numPages }) => {
        this.setState({ numPages });
    };

    handleNext = () => {
        if (this.state.pageNumber < this.state.numPages) {
            this.setState({pageNumber: this.state.pageNumber + 1})
        }
    };

    handlePrevious = () => {
        if (this.state.pageNumber > 1) {
            this.setState({pageNumber: this.state.pageNumber - 1})
        }
    };

    render() {
        const { data } = this.props.location.state;
        const { pageNumber, numPages } = this.state;
        const { classes } = this.props;

        return (
            <div className={classes.root}>
                <CssBaseline />
                <ToolbarDoc
                    next={this.handleNext.bind(this)}
                    prev={this.handlePrevious.bind(this)}
                    pageNumber={this.state.pageNumber}
                    numPages={this.state.numPages}
                />
                <main className={classes.content}>
                    <Document
                        file={`data:application/pdf;base64,${data}`}
                        onLoadSuccess={this.onDocumentLoadSuccess}
                    >
                        <Page
                            className={classes.pageCss}
                            pageNumber={pageNumber}
                        />
                    </Document>
                </main>


            </div>
        );
    }
}
ViewDoc.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles) (ViewDoc);