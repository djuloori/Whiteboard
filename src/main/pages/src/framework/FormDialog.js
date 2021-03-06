import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import PropTypes from "prop-types";
import {withStyles} from "@material-ui/core";
import orange from "@material-ui/core/colors/orange";
import red from "@material-ui/core/colors/red";
import axios from 'axios';

const styles = theme => ({
    cssLabel: {
        fontSize: '20px',
        '&$cssFocused': {
            fontWeight: 'bold',
            color: orange[500]
        },
    },

    cssFocused: {},

    cssOutlinedInput: {
        '&$cssFocused $notchedOutline': {
            borderColor: orange[500],
        },
    },
    notchedOutline: {},

    margin: {
        margin: theme.spacing.unit,
        marginTop: theme.spacing.unit * -2,
    },

    marginError: {
        margin: theme.spacing.unit,
        marginTop: theme.spacing.unit * 1,
        marginBottom: theme.spacing.unit * -2,
    },

    marginContent: {
        margin: theme.spacing.unit,
        marginTop: 0,
    },

    errorCss: {
        fontWeight: 'bold',
        color: red[500],
    },

    cssCancel: {
        float: 'right',
        borderRadius: '10px',
        '&:hover': {
            color: theme.palette.getContrastText(red[500]),
            border: '1px solid red',
            backgroundColor: red[500],
            fontWeight: 'bold',
            boxShadow: '0 0 10px red, 0 0 5px darkred',

        },
    },

    cssSubmit: {
        float: 'right',
        borderRadius: '10px',
        '&:hover': {
            color: theme.palette.getContrastText('#689f38'),
            border: '1px solid green',
            backgroundColor: '#689f38',
            fontWeight: 'bold',
            boxShadow: '0 0 10px green, 0 0 5px darkgreen',

        },
    },
});

class FormDialog extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            open: false,
            error: false,
            updatedAddList: [],
            textField: {},
            textError: '',
            file: null
        };
        this.props.handleFormOn(false);
        this.props.handleUpdateList([]);
    }

    static getDerivedStateFromProps(props, state) {
        if (props.isFormOn !== state.open) {
            return {
                open: props.isFormOn,
            };
        }
        return null;
    }

    handleChangeFor = (propertyName) => (event) => {
        const { textField } = this.state;
        const newTextField = {
            ...textField,
            [propertyName.dataKey]: event.target.value
        };
        this.setState({
            textField: newTextField,
            error: false,
            textError: '',
            file: event.target.files
        });
    };

    handleChangeFile = event => {
        this.setState({
            file: event.target.files
        });
    };

    handleCancel = () => {
        const off = false;
        this.setState({
            open: off,
            textField: {},
            error: false,
            textError: '',
        });
        this.props.handleFormOn(off);
    };

    //This method should be move for each page in the future.
    handleSubmit = () => {
        const { fields, getUrl, addUrl } = this.props;
        const off = false;
        const textFieldJson = this.state.textField;
        var notEmpty = fields.map(({ dataKey }) => {
            if (!textFieldJson[dataKey]) {
                this.setState({
                    error: true,
                    textError: 'Incomplete'
                });
                return false;
            }
            return dataKey;
        });

        if (!notEmpty.includes(false) && !notEmpty.includes('syllabus') && !notEmpty.includes('assignment')) {
            axios.post(addUrl,
                textFieldJson
            ).then(res => {
                if (res.data !== null) {
                    axios.get(getUrl)
                        .then(response => {
                            this.setState({
                                updatedAddList: response.data,
                                textField: {}
                            });
                            this.props.handleUpdateList(response.data);
                        })
                        .catch(error => console.log(error));
                }
            }).catch(error => {
                console.log(error);
            });
            this.setState({
                open: off
            });
            this.props.handleFormOn(off);
        } else if (!notEmpty.includes(false)) {
            var formData = new FormData();
            var pdfFile = this.state.file[0];

            if (pdfFile.type !== 'application/pdf') {
                this.setState({
                    error: true,
                    textError: 'File need to be in PDF'
                });
                return;
            }

            if (textFieldJson.idsyllabus) {
                formData.append('courseId', textFieldJson.class_ID);
                formData.append('idsyllabus', textFieldJson.idsyllabus);
                formData.append('Assignment-doc', pdfFile);
            }
            else if (textFieldJson.assignmentId) {
                formData.append('classid', textFieldJson.class_ID);
                formData.append('Assignment-ID', textFieldJson.assignmentId);
                formData.append('Assignment-Name', textFieldJson.assignmentName);
                formData.append('Total-Points', textFieldJson.totalPoints);
                formData.append('Assignment-doc', pdfFile);
            }

            axios.post(addUrl, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }
            ).then(res => {
                if (res.data !== null) {
                    axios.get(getUrl)
                        .then(response => {
                            this.setState({
                                updatedAddList: response.data,
                                textField: {},
                                file: null
                            });
                            this.props.handleUpdateList(response.data);
                        })
                        .catch(error => console.log(error));
                }
            }).catch(error => {
                console.log(error);
            });
            this.setState({
                open: off
            });
            this.props.handleFormOn(off);
        }
    };

    render() {
        const { classes, fields, dialogTitle, dialogContent } = this.props;
        return (
            <Dialog
                open={this.state.open}
                onClose={this.handleClose}
                aria-labelledby="form-dialog-title"
            >
                <DialogTitle id="form-dialog-title">{dialogTitle}</DialogTitle>
                <DialogContent>
                    <DialogContentText
                        className={classes.marginContent}
                    >
                        {dialogContent}
                    </DialogContentText>
                    {fields.map(({ label, dataKey, type, helperText }, index) => {
                        if (type === 'file') {
                            return (
                                <TextField
                                    error = {this.state.error}
                                    InputLabelProps={{
                                        shrink: true,
                                        classes: {
                                            root: classes.cssLabel,
                                            focused: classes.cssFocused,
                                        },
                                    }}
                                    InputProps={{
                                        classes: {
                                            root: classes.cssOutlinedInput,
                                            focused: classes.cssFocused,
                                            notchedOutline: classes.notchedOutline,
                                        },
                                    }}
                                    margin='normal'
                                    variant='outlined'
                                    key={dataKey}
                                    label={label}
                                    type={type}
                                    fullWidth
                                    onChange={this.handleChangeFor({dataKey})}
                                    helperText={helperText}
                                />
                            );
                        }
                        return (
                            <TextField
                                error = {this.state.error}
                                InputLabelProps={{
                                    shrink: true,
                                    classes: {
                                        root: classes.cssLabel,
                                        focused: classes.cssFocused,
                                    },
                                }}
                                InputProps={{
                                    classes: {
                                        root: classes.cssOutlinedInput,
                                        focused: classes.cssFocused,
                                        notchedOutline: classes.notchedOutline,
                                    },
                                }}
                                margin='normal'
                                variant='outlined'
                                key={dataKey}
                                label={label}
                                type={type}
                                fullWidth
                                onChange={this.handleChangeFor({dataKey})}
                                helperText=''
                            />
                        );
                    })}
                    <DialogContentText
                        className={classes.marginError + ' ' + classes.errorCss}
                    >
                        {this.state.textError}
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button
                        onClick={this.handleCancel}
                        className={classes.cssCancel + ' ' + classes.margin}
                    >
                        Cancel
                    </Button>
                    <Button
                        onClick={this.handleSubmit}
                        className={classes.cssSubmit + ' ' + classes.margin}
                    >
                        Submit
                    </Button>
                </DialogActions>
            </Dialog>
        );
    }
}

FormDialog.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(FormDialog);