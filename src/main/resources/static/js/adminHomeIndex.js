var roleSelect = document.getElementById("roleSelect");
var role = $('input[name="role"]');

roleSelect.addEventListener('click', function() {
    role.attr('value', roleSelect.options[roleSelect.selectedIndex].value);
})

function changeDisable() {
    role.attr('disabled', false);
}