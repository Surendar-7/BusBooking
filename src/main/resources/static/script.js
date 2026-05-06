
        function addBus() {

            let busNo = window.prompt("Enter Bus Number:");
            let fromPlace = window.prompt("Enter From Place:");
            let toPlace = window.prompt("Enter To Place:");
            let price = window.prompt("Enter Price:");


            if (!busNo || !fromPlace || !toPlace || !price) {
                alert("All fields are required!");
                return;
            }

            let busData = { // object creating for data stored in the obj and throws to the api
                busNo: busNo,
                fromPlace: fromPlace,
                toPlace: toPlace,
                price: price
            };

            fetch("/bus/save", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json" // sending data in JSON format
                },
                body: JSON.stringify(busData) // body send the data to server , JSON.stringify convert into json obj , BD user data
            })
            .then(res => res.text()) //Convert the server response into plain text.
            .then(data => {
                alert("Bus saved successfully!");
                location.reload(); // optional refresh
            })
            .catch(err => {
                console.error(err);
                alert("Error saving data");
            });
        }
