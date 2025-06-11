document.addEventListener("DOMContentLoaded", () => {
  const editItemModal = document.getElementById("editItemModal");

  document.querySelectorAll(".editItemBtn").forEach((button) => {

    button.textContent = 'Edit';
    button.addEventListener("click", () => {
      document.getElementById("itemId").value = button.dataset.id;
      document.getElementById("article").value = button.dataset.article;
      document.getElementById("category").value = button.dataset.category;
      document.getElementById("type").value = button.dataset.type;
      document.getElementById("name").value = button.dataset.name;
      document.getElementById("shortDescription").value =
        button.dataset.shortdescription;
      document.getElementById("fullDescription").value =
        button.dataset.fulldescription;
      document.getElementById("imgUrl").value = button.dataset.imgurl;
      document.getElementById("regularPrice").value = button.dataset.regularprice;
      document.getElementById("salePrice").value = button.dataset.saleprice;
      document.getElementById("quantity").value = button.dataset.quantity;
      document.getElementById("isAvailable").checked = button.dataset.isavailable === "true";
      document.getElementById("isOnSale").checked = button.dataset.isonsale === "true";

      editItemModal.style.display = "block";
    });
  });

  document.querySelectorAll(".closeItemModalBtn").forEach(el => {
    el.addEventListener('click', () => {
      editItemModal.style.display = "none";
    })
  })

  window.onclick = function (event) {
    if (event.target === editItemModal) {
      editItemModal.style.display = "none";
    }
  };
})

