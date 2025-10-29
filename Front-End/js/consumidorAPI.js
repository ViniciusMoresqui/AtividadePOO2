const API_URL = "http://localhost:8090/livros";


function listarLivros() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const container = document.getElementById('livros');
            container.innerHTML = "";

            if (data.length === 0) {
                container.innerHTML = "<p>Nenhum livro cadastrado.</p>";
                return;
            }

            data.forEach(livro => {
                const div = document.createElement('div');
                div.classList.add('livro');
                div.innerHTML = `
                    <p><strong>ID:</strong> ${livro.id}</p>
                    <p><strong>Título:</strong> ${livro.titulo}</p>
                    <p><strong>Autor:</strong> ${livro.autor}</p>
                    <p><strong>Gênero:</strong> ${livro.genero}</p>
                    <button onclick="editarLivro(${livro.id}, '${livro.titulo}', '${livro.autor}', '${livro.genero}')">Editar</button>
                    <button onclick="deletarLivro(${livro.id})">Excluir</button>
                `;
                container.appendChild(div);
            });
        })
        .catch(err => console.error("Erro ao listar livros:", err));
}


document.getElementById('formLivro').addEventListener('submit', function (e) {
    e.preventDefault();

    const id = document.getElementById('id').value;
    const titulo = document.getElementById('titulo').value;
    const autor = document.getElementById('autor').value;
    const genero = document.getElementById('genero').value;

    const livro = { titulo, autor, genero };
    const metodo = id ? 'PUT' : 'POST';
    const url = id ? `${API_URL}/${id}` : API_URL;

    fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(livro)
    })
        .then(res => {
            if (!res.ok) throw new Error("Erro ao salvar/atualizar livro");
            return res.json();
        })
        .then(() => {
            alert(id ? "Livro atualizado com sucesso!" : "Livro cadastrado!");
            document.getElementById('formLivro').reset();
            listarLivros();
        })
        .catch(err => alert(err.message));
});


function editarLivro(id, titulo, autor, genero) {
    document.getElementById('id').value = id;
    document.getElementById('titulo').value = titulo;
    document.getElementById('autor').value = autor;
    document.getElementById('genero').value = genero;
}


function deletarLivro(id) {
    if (confirm("Tem certeza que deseja excluir este livro?")) {
        fetch(`${API_URL}/${id}`, { method: 'DELETE' })
            .then(res => {
                if (!res.ok) throw new Error("Erro ao excluir livro");
                alert("Livro excluído com sucesso!");
                listarLivros();
            })
            .catch(err => alert(err.message));
    }
}

if (window.location.pathname.includes("livros.html")) {
    listarLivros();
}

document.getElementById('logout').addEventListener('click', () => {
    window.location.href = 'index.html';
  });