let insuranceQ1Value = parseInt([[${insurance.q1}]]);
let insuranceQ1osValue = '[[${insurance.q1os}]]';
let insuranceQ2Value = parseInt([[${insurance.q2}]]);
let insuranceQ2osValue = '[[${insurance.q2os}]]';
let insuranceQ3Value = '[[${insurance.q3}]]';
let insuranceQ4Value = parseInt([[${insurance.q4}]]);
let insuranceQ5Value = parseInt([[${insurance.q5}]]);
let insuranceQ5osValue = '[[${insurance.q5os}]]';
let insuranceQ6Value = parseInt([[${insurance.q6}]]);
let insuranceQ6osValue = '[[${insurance.q6os}]]';
let insuranceQ7Value = '[[${insurance.q7}]]';

autofillClosedQuestionsFromDB(1, insuranceQ1Value)
autofillOpenQuestionsFromDB("q1os", insuranceQ1osValue)
autofillClosedQuestionsFromDB(2, insuranceQ2Value)
autofillOpenQuestionsFromDB("q2os", insuranceQ2osValue)
autofillOpenQuestionsFromDB("textarea_3", insuranceQ3Value)
autofillClosedQuestionsFromDB(4, insuranceQ4Value)
autofillClosedQuestionsFromDB(5, insuranceQ5Value)
autofillOpenQuestionsFromDB("q5os", insuranceQ5osValue)
autofillClosedQuestionsFromDB(6, insuranceQ6Value)
autofillOpenQuestionsFromDB("q6os", insuranceQ6osValue)
autofillOpenQuestionsFromDB("textarea_7", insuranceQ7Value)

function autofillClosedQuestionsFromDB(questionNumber, questionValue) {
    document.getElementById("radio_" + questionNumber + "_" + (questionValue - 1)).checked = true;
}

function autofillOpenQuestionsFromDB(questionId, questionValue) {
    if (questionValue !== null && questionValue !== "" && questionValue !== "NA") {
        document.getElementById(questionId).value = questionValue;
    }
}