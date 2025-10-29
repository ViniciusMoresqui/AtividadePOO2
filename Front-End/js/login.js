
document.getElementById('loginForm').addEventListener('submit', function(e) {
      e.preventDefault();
      const usuario = document.getElementById('usuario').value.trim();
      const senha = document.getElementById('senha').value.trim();
      const erro = document.getElementById('erro');

      if (usuario === 'admin' && senha === '1234') {
        window.location.href = 'livros.html';
      } else {
        erro.textContent = 'Usuário ou senha incorretos.';
      }
 });