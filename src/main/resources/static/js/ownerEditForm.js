var roleSelect = document.getElementById("roleSelect");
var role = $('input[name="role"]');

roleSelect.addEventListener('click', function() {
    role.attr('value', roleSelect.options[roleSelect.selectedIndex].value);
})

function SetDest1() {
    role.attr('disabled', false);
    document.forms["ownerEditForm"].action = "/editOwner";
}

function SetDest2() {
    document.forms["ownerEditForm"].action = "/deleteOwner";
}