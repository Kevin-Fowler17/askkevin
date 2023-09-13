// Function to show/hide the element based on input value
function toggleQuestionVisibility() {
    let input = document.getElementsByName("q2");
    let showHide = document.getElementById("q3");

    // Check if any radio button with the same name is checked
    for (let i = 0; i < input.length; i++) {
        if (input[i].checked && input[i].value === "1") {
            showHide.style.display = "block"; // Show the element
            return;// Exit the loop once a checked radio button with value "1" is found
        }

        // If no radio button with value "1" is checked, hide the element
        showHide.style.display = "none";
    }

    // If no radio button with value "1" is checked, hide the element
    showHide.style.display = "none";
}

// Add change event listeners to all radio buttons with the same name
let input = document.getElementsByName("q2");

for (let i = 0; i < input.length; i++) {
    input[i].addEventListener("change", toggleQuestionVisibility);
}

// Call the function initially to set the initial state
toggleQuestionVisibility();