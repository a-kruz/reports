var sd;
var ed;

function dateChange() {
    var tp = document.getElementById("tp").value;
    
    switch(tp) {
        case "Last Qtr":
            lastQtr();
            break;
        case "Last Month":
            lastMonth();
            break;
        case "Last Calendar Year":
            lastCalendarYear();
            break;
        case "Current Year to Date":
            currentYear();
            break;
        case "Current Qtr to Date":
            currentQtr();
            break;
        case "Current Month to Date":
            currentMonth();
            break;
        default:
            defaultEmpty();
    }
    if ((sd != '') && (ed != '')) {
        sd = sd.format("MMM D, YYYY");
        ed = ed.format("MMM D, YYYY");
    }
    document.getElementById("start").value = sd;
    document.getElementById("end").value = ed; 
}
    
function lastQtr() {
    if (moment().quarter() == 1) {
        sd = moment({year: moment().year()-1, month:9, day:1});
    } else {
        sd = moment({month:Math.floor((moment().month()-3)/3)*3, day:1});
    }
    ed = sd.clone().add(2, 'M').endOf('month');
}

function lastMonth() {
    sd = moment().subtract(1, 'M').startOf('month');
    ed = moment().subtract(1, 'M').endOf('month');
}

function lastCalendarYear() {
    sd = moment().subtract(1, 'y').startOf('year').startOf('month');
    ed = moment().subtract(1, 'y').endOf('year').endOf('month');
}

function currentYear() {
    sd = moment().startOf('year').startOf('month');
    ed = moment();
}

function currentQtr() {
    sd = moment({month:Math.floor(moment().month()/3)*3, day:1});
    ed = moment();
}

function currentMonth() {
    sd = moment().startOf('month');
    ed = moment();
}

function defaultEmpty() {
    sd = '';
    ed = '';
}