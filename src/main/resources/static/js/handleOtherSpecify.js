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
toggleOtherTextBox('input[name="q3"]', '#radio_3_25', '#q3os');
