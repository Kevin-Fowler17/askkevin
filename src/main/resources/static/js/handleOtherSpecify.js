function toggleOtherTextBox(radioSelector, otherOptionSelector, otherTextBoxSelector) {
    const radios = document.querySelectorAll(radioSelector);
    const otherOption = document.querySelector(otherOptionSelector);
    const otherTextBox = document.querySelector(otherTextBoxSelector);

    function toggleTextBox() {
        otherTextBox.style.display = otherOption.checked ? 'block' : 'none';
    }

    radios.forEach(radio => {
        radio.addEventListener('change', toggleTextBox);
    });

    toggleTextBox();
}

toggleOtherTextBox('input[name="q1"]', '#radio_1_25', '#q1os');
toggleOtherTextBox('input[name="q2"]', '#radio_2_5', '#q2os');
toggleOtherTextBox('input[name="q5"]', '#radio_5_25', '#q5os');
toggleOtherTextBox('input[name="q6"]', '#radio_6_5', '#q6os');
