// Wait for the DOM to be fully loaded before running
document.addEventListener("DOMContentLoaded", function () {

    // Retrieve the value of insurance.q4 from your HTML
    let insuranceQ4Value = parseInt([[${insurance.q4}]]);

    // Check if insuranceQ4Value is not equal to 1
    if (insuranceQ4Value !== 1) {
        // Initially hide questions
        document.getElementById("q5").style.display = "none";
        document.getElementById("q6").style.display = "none";
        document.getElementById("q7").style.display = "none";
    }

});

// Function to show/hide the questions based on q4
function toggleQuestionVisibility(inputQuestion, showHideQuestion) {
    let input = document.getElementsByName(inputQuestion);
    let showHide = document.getElementById(showHideQuestion);

    // Check if any radio button with the same name is checked
    for (let i = 0; i < input.length; i++) {
        if (input[i].checked && input[i].value === "1") {
            showHide.style.display = "block"; // Show the element
            return; // Exit the loop once a checked radio button with value "1" is found
        }
    }

    // If no radio button with value "1" is checked, hide the element
    showHide.style.display = "none";
}

// Add change event listeners to all radio buttons with the same name
let input = document.getElementsByName("q4");

for (let i = 0; i < input.length; i++) {
    input[i].addEventListener("change", function () {
        toggleQuestionVisibility("q4", "q5");
        toggleQuestionVisibility("q4", "q6");
        toggleQuestionVisibility("q4", "q7");
    });
}
