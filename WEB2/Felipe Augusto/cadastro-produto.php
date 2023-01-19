<?php
  require_once "consultar-produto.php";
?>
<!doctype html>
<html lang="pt">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title>Cadastro de Produtos</title>
</head>

<body>

  <div class="jumbotron jumbotron-fluid bg-transparent">
    <div class="container ">
      <h1 class="display-6 text-secondary text-center">Cadastro de Produtos</h1>
    </div>
  </div>

  <!-- Form -->
  <div class="row justify-content-center">

    <div class="container col-md-6 ">

      <form action="inserir-produto.php" method="POST">

        <!-- Row 1 -->
        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="inputDescricao">Descrição</label>
            <input type="text" class="form-control" name="inputDescricao" id="inputDescricao" placeholder="Descrição do produto" required>
          </div>

        </div>

        <!-- Row 2 -->
        <div class="form-row">

          <div class="col-md-3 mr-4">
            <div class="form-group">
              <label for="inputPreco">Preço</label>
              <input type="number" class="form-control" name="inputPreco" id="inputPreco" placeholder="1,00" step="0.01" min="0" required>
            </div>
          </div>

          <div class="form-group col-md-3">
            <label for="inputQt">Quantidade</label>
            <input type="number" class="form-control" name="inputQt" id="inputQt" min="1" placeholder="1" required>
          </div>

        </div>

        <!-- Row3 -->
        <div class="form-row justify-content-center mt-4">

          <button class="btn btn-outline-primary col-md-10" type="submit" name="btCadastrar">Cadastrar</button>
        </div>

      </form>

    </div>

  </div>

  <div class="container ">

    <table class="table table-hover mt-5">

      <thead class="thead-light">
        <tr class="text-center">
          <th scope="col">Código</th>
          <th scope="col">Descrição</th>
          <th scope="col">Estoque</th>
          <th scope="col">Preço</th>
          <th scope="col"></th>
        </tr>
      </thead>

      <tbody>

        <?php foreach ($lista_produtos as $linha) {
          $link_excluir = "excluir-produto.php?id=" . $linha['id'];
          $link_editar = "editar-produto.php?id=" . $linha['id'];
        ?>
          <tr class="text-center">
            <!--td ><? //php echo $i; 
                    ?> </td-->
            <td> <?php echo $linha['id']; ?> </td>
            <td class="align-text-top"> <?php echo $linha['descricao']; ?> </td>
            <td> <?php echo $linha['qt']; ?> </td>
            <td> <?php echo "R$ " . number_format($linha['preco'], 2, ',', ''); ?> </td>
            <td> 
              <a class="btn btn-outline-primary mr-2" href=<?php echo $link_editar; ?> role="button">Editar</a> 
              <a class="btn btn-outline-primary" href=<?php echo $link_excluir; ?> role="button">Excluir</a>
            </td>
          </tr>

        <?php }; //end foreach 
        ?>

      </tbody>
    </table>
  </div>

  




  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>