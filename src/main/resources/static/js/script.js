document.addEventListener("DOMContentLoaded", () => {
  const editItemModal = document.getElementById("editItemModal");
  const editUserModal = document.getElementById("editUserModal");

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
      document.getElementById("available").checked = button.dataset.available === "true";
      document.getElementById("sale").checked = button.dataset.sale === "true";
      editItemModal.style.display = "block";
    });
  });

  document.querySelectorAll(".editUserBtn").forEach((button) => {
    button.addEventListener('click', () => {
      document.getElementById('userId').value = button.dataset.id;
      document.getElementById('firstname').value = button.dataset.firstname;
      document.getElementById('lastname').value = button.dataset.lastname;
      document.getElementById('email').value = button.dataset.email;
      document.getElementById('phone').value = button.dataset.phone;
      document.getElementById('role').value = button.dataset.role;
      editUserModal.style.display = "block";
    })
  })

  document.querySelectorAll(".closeItemModalBtn").forEach(el => {
    el.addEventListener('click', () => {
      editItemModal.style.display = "none";
    })
  })

  document.querySelectorAll(".closeUserModalBtn").forEach(el => {
    el.addEventListener('click', () => {
      editItemModal.style.display = "none";
    })
  })

  window.onclick = function (event) {
    if (event.target === editItemModal) {
      editItemModal.style.display = "none";
    }
  };

  window.onclick = function (event){
    if(event.target === editUserModal){
      editUserModal.style.display = "none";
    }
  }
})

