const openEl = document.getElementById('open'),
      modalContainerEl = document.getElementById('modal_container'),
      closeEl = document.getElementById('close');

openEl.addEventListener('click', () => {
    modalContainerEl.classList.add('show');
});

closeEl.addEventListener('click', () => {
    modalContainerEl.classList.remove('show');
});