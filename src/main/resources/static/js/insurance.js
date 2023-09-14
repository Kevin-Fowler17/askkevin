"use strict";

(function () {

    // This is the class where the questions will be displayed in the html
    const displayQ1 = document.getElementsByClassName("q1")[0];
    const displayQ2 = document.getElementsByClassName("q2")[0];
    const displayQ3 = document.getElementsByClassName("q3")[0];
    const displayQ4 = document.getElementsByClassName("q4")[0];
    const displayQ5 = document.getElementsByClassName("q5")[0];
    const displayQ6 = document.getElementsByClassName("q6")[0];
    const displayQ7 = document.getElementsByClassName("q7")[0];

    // Arrays to store the variable names for each question
    let q1Layout = [];
    let q2Layout = [];
    let q3Layout = [];
    let q4Layout = [];
    let q5Layout = [];
    let q6Layout = [];
    let q7Layout = [];

    // Array(s) to store the answer options for each question
    let questionText = [
        {'value': 1, 'label': 'What is your primary insurance company?'},
        {'value': 2, 'label': 'What type is your primary insurance company?'},
        {'value': 3, 'label': 'What is the id of your primary insurance company?'},
        {'value': 4, 'label': 'Do you have a secondary insurance company?'},
        {'value': 5, 'label': 'What is your secondary insurance company?'},
        {'value': 6, 'label': 'What type is your secondary insurance company?'},
        {'value': 7, 'label': 'What is the id of your secondary insurance company?'}
    ]

    let insuranceCompanies = [
        {'value': 1, 'label': 'Anthem Inc.'},
        {'value': 2, 'label': 'Blue Cross Blue Shield of California'},
        {'value': 3, 'label': 'Blue Cross Blue Shield of Massachusetts'},
        {'value': 4, 'label': 'Blue Cross Blue Shield of New Jersey'},
        {'value': 5, 'label': 'Blue Cross Blue Shield of North Carolina'},
        {'value': 6, 'label': 'Blue Cross of Michigan'},
        {'value': 7, 'label': 'California Physicians’ Service'},
        {'value': 8, 'label': 'Carefirst Inc.'},
        {'value': 9, 'label': 'Caresource'},
        {'value': 10, 'label': 'Centene Corporation'},
        {'value': 11, 'label': 'CIGNA'},
        {'value': 12, 'label': 'CVS Health'},
        {'value': 13, 'label': 'Guidewell Mutual Holding'},
        {'value': 14, 'label': 'Health Care Service Corporation (HCSC)'},
        {'value': 15, 'label': 'Health Net of California'},
        {'value': 16, 'label': 'Highmark Group'},
        {'value': 17, 'label': 'Humana'},
        {'value': 18, 'label': 'Independence Health Group'},
        {'value': 19, 'label': 'Kaiser Foundation'},
        {'value': 20, 'label': 'Local Initiative Health Authority'},
        {'value': 21, 'label': 'Metropolitan'},
        {'value': 22, 'label': 'Molina Healthcare'},
        {'value': 23, 'label': 'Point32Health'},
        {'value': 24, 'label': 'United Health'},
        {'value': 25, 'label': 'UPMC Health System'}
    ]

    let insurancePlanType = [
        {'value': 1, 'label': 'Health maintenance organizations (HMOs)'},
        {'value': 2, 'label': 'Preferred provider organizations (PPOs)'},
        {'value': 3, 'label': 'Exclusive provider organizations (EPOs)'},
        {'value': 4, 'label': 'Point-of-service (POS) plans'},
        {'value': 5, 'label': 'High-deductible health plans (HDHPs)'}
    ]

    let yesNo = [
        {'value': 1, 'label': 'Yes'},
        {'value': 2, 'label': 'No'}
    ];

    let workingArray = [];

    renderQ1(0);
    renderQ2(1);
    renderQ3(2);
    renderQ4(3);
    renderQ5(4);
    renderQ6(5);
    renderQ7(6);

    function renderQ1(questionArrayPosition) {
        generateHTMLLayoutForSRandMR(q1Layout, insuranceCompanies, true, false, false);
        customizeHTMLLayoutForSRandMR(q1Layout, questionArrayPosition, workingArray,true);
        addInputBoxForOther(q1Layout, "q1os");
        appendElementsToDocForSRandMR(q1Layout, workingArray, displayQ1);
    }

    function renderQ2(questionArrayPosition) {
        generateHTMLLayoutForSRandMR(q2Layout, insurancePlanType, true, false, false);
        customizeHTMLLayoutForSRandMR(q2Layout, questionArrayPosition, workingArray,true);
        addInputBoxForOther(q2Layout, "q2os");
        appendElementsToDocForSRandMR(q2Layout, workingArray, displayQ2);
    }

    function renderQ3(questionArrayPosition) {
        generateHTMLLayoutForOpenEnd(q3Layout);
        customizeHTMLLayoutForOpenEnd(q3Layout, questionArrayPosition);
        appendElementsToDocForOpenEnd(q3Layout, displayQ3);
    }

    function renderQ4(questionArrayPosition) {
        generateHTMLLayoutForSRandMR(q4Layout, yesNo, false, false, false);
        customizeHTMLLayoutForSRandMR(q4Layout, questionArrayPosition, workingArray,true);
        addInputBoxForOther(q4Layout);
        appendElementsToDocForSRandMR(q4Layout, workingArray, displayQ4);
    }

    function renderQ5(questionArrayPosition) {
        generateHTMLLayoutForSRandMR(q5Layout, insuranceCompanies, true, false, false);
        customizeHTMLLayoutForSRandMR(q5Layout, questionArrayPosition, workingArray,true);
        addInputBoxForOther(q5Layout, "q5os");
        appendElementsToDocForSRandMR(q5Layout, workingArray, displayQ5);
    }

    function renderQ6(questionArrayPosition) {
        generateHTMLLayoutForSRandMR(q6Layout, insurancePlanType, true, false, false);
        customizeHTMLLayoutForSRandMR(q6Layout, questionArrayPosition, workingArray,true);
        addInputBoxForOther(q6Layout, "q6os");
        appendElementsToDocForSRandMR(q6Layout, workingArray, displayQ6);
    }

    function renderQ7(questionArrayPosition) {
        generateHTMLLayoutForOpenEnd(q7Layout);
        customizeHTMLLayoutForOpenEnd(q7Layout, questionArrayPosition);
        appendElementsToDocForOpenEnd(q7Layout, displayQ7);
    }

    function generateHTMLLayoutForSRandMR(layoutName, answerArray, otherOption, noneOption, refusedOption) {

        workingArray = answerArray.slice();

        otherOption && workingArray.push({'value': 97, 'label': 'Other'});
        noneOption && workingArray.push({'value': 98, 'label': 'None'});
        refusedOption && workingArray.push({'value': 99, 'label': 'Refused'});

        let surveyQuestion = document.createElement("div");
        let questionLabel = document.createElement("label");
        let divRadioGroup = document.createElement("div");

        layoutName.push(surveyQuestion, questionLabel, divRadioGroup);

        for (let i = 0; i < workingArray.length; i++) {
            // Create the div element
            let divFormCheck = document.createElement("div");

            // Create the input element
            let input = document.createElement("input");

            // Create the label element
            let label = document.createElement("label");

            // Store the values in the array
            layoutName.push(divFormCheck, input, label);
        }
    }

    function generateHTMLLayoutForOpenEnd(layoutName) {

        let surveyQuestion = document.createElement("div");
        let questionLabel = document.createElement("label");
        let divRadioGroup = document.createElement("div");
        let divFormCheck = document.createElement("div");
        let textarea = document.createElement("textarea");

        // Store the values in the array
        layoutName.push(surveyQuestion, questionLabel, divRadioGroup, divFormCheck, textarea);
    }

    function customizeHTMLLayoutForSRandMR(layoutName, questionArrayPosition, answerArray, singleType) {

        let layoutStartingPosition = 3;
        let groupType = "";
        let questionType = "";

        if (singleType) {
            groupType = "radio-group";
            questionType = "radio";
        } else {
            groupType = "checkbox-group";
            questionType = "checkbox";
        }

        layoutName[0].className = "survey-question";

        layoutName[1].className = "pb-2 pt-3";
        layoutName[1].setAttribute("for", groupType);
        layoutName[1].innerHTML = "Q" + questionText[questionArrayPosition].value + ". " + questionText[questionArrayPosition].label;

        layoutName[2].className = "";
        layoutName[2].setAttribute("class", groupType);
        layoutName[2].setAttribute("id", groupType + "_" + (questionArrayPosition + 1));

        for (let i = 0; i < answerArray.length; i++) {

            layoutName[layoutStartingPosition].className = "form-check pb-2";

            layoutName[layoutStartingPosition + 1].setAttribute("type", questionType);
            layoutName[layoutStartingPosition + 1].className = "form-check-input";
            layoutName[layoutStartingPosition + 1].setAttribute("id",questionType + "_" + questionText[questionArrayPosition].value + "_" + i);
            layoutName[layoutStartingPosition + 1].setAttribute("name","q" + questionText[questionArrayPosition].value)
            layoutName[layoutStartingPosition + 1].setAttribute("value", answerArray[i].value);

            layoutName[layoutStartingPosition + 2].className = "form-check-label";
            layoutName[layoutStartingPosition + 2].setAttribute("for",questionType + "_" + questionText[questionArrayPosition].value + "_" + i);
            layoutName[layoutStartingPosition + 2].innerHTML = answerArray[i].label;

            layoutStartingPosition += 3;
        }
    }

    function customizeHTMLLayoutForOpenEnd(layoutName, questionArrayPosition) {

        layoutName[0].className = "survey-question";

        layoutName[1].className = "pb-2 pt-3";
        layoutName[1].setAttribute("for", "textarea");
        layoutName[1].innerHTML = "Q" + questionText[questionArrayPosition].value + ". " + questionText[questionArrayPosition].label;

        layoutName[2].className = "";
        layoutName[2].setAttribute("class", "textarea");
        layoutName[2].setAttribute("id", "textarea" + "_" + (questionArrayPosition + 1));

        layoutName[3].className = "form-textarea pb-2";

        layoutName[4].setAttribute("type", "textarea");
        layoutName[4].className = "form-textarea-input";
        layoutName[4].setAttribute("id","textarea_" + questionText[questionArrayPosition].value);
        layoutName[4].setAttribute("name","q" + questionText[questionArrayPosition].value);
        layoutName[4].setAttribute('data-th-field', '*{q' + questionText[questionArrayPosition].value +'}');
    }

    function addInputBoxForOther(layoutName, textBoxID) {

        layoutName.forEach((element, index) => {
            if (element.textContent === "Other") {

                // Create a new element to be inserted
                let otherInputBox = document.createElement("input");
                otherInputBox.setAttribute("type", "text");
                otherInputBox.setAttribute("id", textBoxID);

                // Insert the new element after the element with "Other"
                layoutName[index].appendChild(otherInputBox);
            }
        });
    }

    function appendElementsToDocForSRandMR(layoutName, answerArray, displayQuestion) {

        let layoutStartingPosition = 3;

        for (let i = 0; i < answerArray.length; i++) {
            layoutName[layoutStartingPosition].appendChild(layoutName[layoutStartingPosition + 1]);
            layoutName[layoutStartingPosition].appendChild(layoutName[layoutStartingPosition + 2]);

            layoutName[2].appendChild(layoutName[layoutStartingPosition]);

            layoutStartingPosition += 3;
        }

        layoutName[0].appendChild(layoutName[1]);
        layoutName[0].appendChild(layoutName[2]);

        displayQuestion.appendChild(layoutName[0]);

        workingArray = [];
    }

    function appendElementsToDocForOpenEnd(layoutName, displayQuestion) {

        layoutName[3].appendChild(layoutName[4]);

        layoutName[2].appendChild(layoutName[3]);

        layoutName[0].appendChild(layoutName[1]);
        layoutName[0].appendChild(layoutName[2]);

        displayQuestion.appendChild(layoutName[0]);
    }

})();