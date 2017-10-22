$(document).ready(function(){
    var vatInput = $('input[name="vat"]');
    var plateNumberInput=$('input[name="plateNumber"]');

    var dateInput = $('input[name="date"]');
    var dateToInput=$('input[name="dateTo"]');
    var checkboxPeriodSearch = $('input[name="periodSearch"]');
    var checkBoxPeriodSearch = document.querySelector("input[name=periodSearch]");

    var checkboxCaseSearch = $('input[name="caseSearch"]');
    var checkBoxCaseSearch = document.querySelector("input[name=caseSearch]");

    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    dateInput.datepicker({
        format: 'yyyy-mm-dd',
        container: container,
        todayHighlight: true,
        autoclose: true
    });
    dateToInput.datepicker({
        format: 'yyyy-mm-dd',
        container: container,
        todayHighlight: true,
        autoclose: true
    });

    dateToInput.hide();

    checkBoxPeriodSearch.addEventListener('change', function() {
        if(this.checked) {
            dateToInput.required = true;
            dateToInput.show();
            dateInput.attr('placeholder', 'Select Date From');
            dateToInput.attr('placeholder', 'Select Date To');
        } else {
            dateToInput.required = false;
            dateToInput.hide();
            dateInput.attr('placeholder', 'YYYY-MM-DD');
        }
    });

    plateNumberInput.hide();
    checkBoxCaseSearch.addEventListener('change', function() {
        if(this.checked) {
            vatInput.required = false;
            plateNumberInput.required = true;
            plateNumberInput.show();
            vatInput.hide();
        } else {
            vatInput.required = true;
            plateNumberInput.required = false;
            plateNumberInput.hide();
            vatInput.show();
        }
    });

})