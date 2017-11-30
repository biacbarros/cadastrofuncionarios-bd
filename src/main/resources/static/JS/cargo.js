$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var idcargo = button.data('id');
	var nomecargo = button.data('descricao');
	
	var modal = $(this);
	
	var form = modal.find('form');
	
	var action = form.data('url-base');
	
	if (!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action + idcargo);
	modal.find('.modal-body span')
			.html('Tem certeza que deseja excluir o funcionário <strong>' 
					+ nomecargo + ' </strong>?');
});