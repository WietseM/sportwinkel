"use strict"

document.getElementById("post").onclick = async function () {
    const artikel = {
        naam: document.getElementById("naam").value,
        aankoopprijs: document.getElementById("aankoop").value,
        verkoopprijs: document.getElementById("verkoop").value
    };
    const response = await fetch("artikels",
        {
            method: "POST",
            headers: {'Content-Type': "application/json"},
            body: JSON.stringify(artikel)
        });
    if (response.ok){
        document.getElementById("goed").hidden = false;
    } else {
        document.getElementById("slecht").hidden = false;
    }
}