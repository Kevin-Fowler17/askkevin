// Wait for the DOM to be fully loaded before running
document.addEventListener("DOMContentLoaded", function () {
    // Initially hide questions
    document.getElementById("q5").style.display = "none";
    document.getElementById("q6").style.display = "none";
    document.getElementById("q7").style.display = "none";
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

console.log("input: " + input)
console.log("input length: " + input.length)

for (let i = 0; i < input.length; i++) {
    input[i].addEventListener("change", function () {
        toggleQuestionVisibility("q4", "q5");
        toggleQuestionVisibility("q4", "q6");
        toggleQuestionVisibility("q4", "q7");
    });
}
