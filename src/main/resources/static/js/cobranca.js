$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event)){
	var button = $(event.relatedTarget);
	
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');
	
	var modal = $(this);
	
	var form = modal.find('form');
	
	var action = form.data('url-base');
	
	//se a url nao terminar com barra(/), uma barra (/) é adicionada para padronizar
	if(!action.endsWith('/')){
		action += '/';
	}
}