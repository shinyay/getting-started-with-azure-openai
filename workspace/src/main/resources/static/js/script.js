// JavaScript code for handling button actions and AJAX requests

document.addEventListener("DOMContentLoaded", function () {
    // Attach event listener to form submission
    document.querySelector("form").addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the form from submitting via the browser

        const promptInput = document.querySelector("#prompt").value;
        fetch("/generate", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: `prompt=${encodeURIComponent(promptInput)}`
        })
            .then(response => response.text())
            .then(data => {
                document.querySelector("#response").value = data; // Set the response text as the value of the textarea
            })
            .catch(error => console.error('Error:', error));
    });

    // Attach event listener to clear button
    document.querySelector("button[type='reset']").addEventListener("click", function () {
        document.querySelector("#response").innerHTML = ""; // Clear the response area
    });
});
