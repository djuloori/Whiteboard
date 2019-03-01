import React from "react";
import Paper from '@material-ui/core/Paper';
import axios from 'axios';
import VirtualizedTable from '../framework/VirtualizedTable';
import DeleteButton from '../framework/DeleteButton';
import AddButton from '../framework/AddButton';
import FormDialog from '../framework/FormDialog';
import PropTypes from "prop-types";
import CssBaseline from "@material-ui/core/CssBaseline";
import ToolbarView from "../shared/ToolbarView";
import Typography from "@material-ui/core/Typography";
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import withStyles from "@material-ui/core/styles/withStyles";
import orange from '@material-ui/core/colors/orange';

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
        marginBottom: theme.spacing.unit * 2,
        display: 'inline-block',

    },

    content: {
        flexGrow: 1,
        padding: theme.spacing.unit * 3,
    },

    editswitch: {
        display: 'inline-block',
        float: 'right',
    },

    editlabel: {
        fontSize: '18px',
        fontWeight: 'bold',
        marginTop: -16,
    },

    iOSSwitchBase: {
        '&$iOSChecked': {
            color: theme.palette.common.white,
            '& + $iOSBar': {
                backgroundColor: '#52d869',
            },
        },
        transition: theme.transitions.create('transform', {
            duration: theme.transitions.duration.shortest,
            easing: theme.transitions.easing.sharp,
        }),
    },

    iOSChecked: {
        transform: 'translateX(15px)',
        '& + $iOSBar': {
            opacity: 1,
            border: 'none',
        },
    },

    iOSBar: {
        borderRadius: 13,
        width: 42,
        height: 26,
        marginTop: -22,
        marginLeft: -21,
        border: 'solid 1px',
        borderColor: theme.palette.grey[400],
        backgroundColor: theme.palette.grey[50],
        opacity: 1,
        transition: theme.transitions.create(['background-color', 'border']),
    },

    iOSIcon: {
        width: 24,
        height: 24,
        marginTop: -19,
    },

    iOSIconChecked: {
        boxShadow: theme.shadows[1],
    },
});

class TableView extends React.Component{
    render() {
        const items = this.props.items;
        return(
            <Paper style={{ height: 400, width: '100%' }}>
                <VirtualizedTable
                    rowCount={items.length}
                    rowGetter={({ index }) => items[index]}
                    columns={[
                        {
                            width: 200,
                            flexGrow: 0.5,
                            label: 'Class ID',
                            dataKey: 'classId',
                            numeric: true
                        },
                        {
                            width: 120,
                            flexGrow: 0.5,
                            label: 'Class Name',
                            dataKey: 'className',
                        }
                    ]}
                />
            </Paper>
        )
    }
}

class TableEdit extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            selectedIndex: [],
        };
        this.handleSelectedRow = this.handleSelectedRow.bind(this);
        this.props.handleSelectedIndexFromTableEdit([]);
    };
    static getDerivedStateFromProps(props, state) {
        if (props.selectedIndexRender !== state.selectedIndex) {
            return {
                selectedIndex: props.selectedIndexRender,
            };
        }
        return null;
    }
    handleSelectedRow = ({index}) => {
        var selected  = [...this.state.selectedIndex];
        if (selected.includes(index)){
             selected.splice(selected.indexOf(index),1);
        } else {
             selected.push(index);
        }
        this.setState({selectedIndex: selected});
        this.props.handleSelectedIndexFromTableEdit(selected);
    };

    handleSelectedRowStyle = ({index}) => {
        if (this.state.selectedIndex.includes(index)) {
            return ({backgroundColor: orange[200]});
        }
    };
    render() {
        const items = this.props.items;
        return(
            <div>
                <Paper style={{ height: 400, width: '100%' }}>
                    <VirtualizedTable
                        rowCount={items.length}
                        rowGetter={({ index }) => items[index]}
                        onRowClick={this.handleSelectedRow}
                        rowStyle={this.handleSelectedRowStyle}
                        columns={[
                            {
                                width: 200,
                                flexGrow: 0.5,
                                label: 'Class ID',
                                dataKey: 'classId',
                                numeric: true
                            },
                            {
                                width: 120,
                                flexGrow: 0.5,
                                label: 'Class Name',
                                dataKey: 'className',
                            }
                        ]}
                    />
                </Paper>
            </div>
        )
    }
}

class TableRender extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            selectedIndexRender: [],
        };
        this.handleSelectedIndexFromTableEdit = this.handleSelectedIndexFromTableEdit.bind(this);
    }
    static getDerivedStateFromProps(props, state) {
        if (props.selectedIndexPage !== state.selectedIndexRender) {
            return {
                selectedIndexRender: props.selectedIndexPage,
            };
        }
        return null;
    }
    handleSelectedIndexFromTableEdit(selected) {
        this.props.handleSelectedIndexFromTableRender(selected);
    }
    render() {
        const isEditOn = this.props.isEditOn;
        if (isEditOn) {
            return(
                <TableEdit
                    items = {this.props.loadItems}
                    selectedIndexRender = {this.state.selectedIndexRender}
                    handleSelectedIndexFromTableEdit = {this.handleSelectedIndexFromTableEdit}
                />
            )
        }
        else {
            return (
                <TableView items = {this.props.loadItems}/>
            )
        }
    }
}

class CoursesPage extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            items: [],
            selectedIndexPage: [],
            isLoaded: false,
            isOn: false,
            isFormOn: false
        };
        this.handleSelectedIndexFromTableRender = this.handleSelectedIndexFromTableRender.bind(this);
        this.handleDeleteItem = this.handleDeleteItem.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleFormOn = this.handleFormOn.bind(this);
        this.handleUpdateList = this.handleUpdateList.bind(this);
    }
    componentDidMount() {
        axios.get('app/Classes/getCourses')
            .then(response => this.setState({ items: response.data }))
            .catch(error => console.log(error));
    }
    handleChangeEdit = name => event => {
        this.setState({ [name]: event.target.checked });
    }
    handleSelectedIndexFromTableRender(selected){
        this.setState({selectedIndexPage: selected});
    }
    handleDeleteItem() {
        var allItems = this.state.items;
        var allItemsIndex = Array.apply(null, Array(allItems.length)).map(function (x, i) { return i; });
        var selectedIndexPage = this.state.selectedIndexPage;
        var filteredItems = allItems.filter(item => !selectedIndexPage.includes(allItems.indexOf(item)));

        if (selectedIndexPage.length === 0) {
            this.setState({items: []});
            selectedIndexPage = allItemsIndex;
        } else {
            this.setState({items: filteredItems});
        }

        try {
            axios.all(selectedIndexPage.map(i => axios.delete('app/Classes/DeleteClass/' + allItems[i].classId)));
            this.setState({selectedIndexPage: []});
        } catch (error) {
            console.log('Fail to delete item' + error);
            this.setState({
                items: allItems,
                selectedIndexPage: []
            });
        }
    }
    handleAddItem() {
        this.setState({isFormOn: true});
    }
    handleFormOn(off) {
        this.setState({isFormOn: off});
    }
    handleUpdateList(updatedAddList) {
        this.setState({items: updatedAddList});
    }
    render() {
        var { isLoaded, items } = this.state;
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
                    <FormGroup row className={classes.editswitch}>
                        <FormControlLabel classes={{ label: classes.editlabel }}
                            control={
                                <Switch
                                    classes={{
                                        switchBase: classes.iOSSwitchBase,
                                        bar: classes.iOSBar,
                                        icon: classes.iOSIcon,
                                        iconChecked: classes.iOSIconChecked,
                                        checked: classes.iOSChecked,
                                    }}
                                    checked={this.state.isOn}
                                    onChange={this.handleChangeEdit('isOn')}
                                    value="false"
                                />
                            }
                            label='Edit'
                        />
                    </FormGroup>
                    <TableRender
                        isEditOn={this.state.isOn}
                        loadItems={this.state.items}
                        selectedIndexPage={this.state.selectedIndexPage}
                        handleSelectedIndexFromTableRender = {this.handleSelectedIndexFromTableRender}
                    />
                    <div>
                        <AddButton
                            isEditOn={this.state.isOn}
                            onClick={this.handleAddItem}
                        />
                        <DeleteButton
                            isEditOn={this.state.isOn}
                            selectedIndex={this.state.selectedIndexPage}
                            onClick={this.handleDeleteItem}
                        />
                    </div>
                    <FormDialog
                        isFormOn={this.state.isFormOn}
                        dialogTitle='Add Course'
                        dialogContent='Please fill in the course information'
                        addCourseUrl='/app/Classes/AddClass'
                        getCourseUrl='app/Classes/getCourses'
                        handleFormOn={this.handleFormOn}
                        handleUpdateList={this.handleUpdateList}
                        fields={[
                            {
                                label: 'Class ID',
                                dataKey: 'classId',
                                type: 'number'
                            },
                            {
                                label: 'Class Name',
                                dataKey: 'className',
                                type: 'text'
                            }
                        ]}
                    />
                </main>
            </div>
        );
    }
}

CoursesPage.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles) (CoursesPage);