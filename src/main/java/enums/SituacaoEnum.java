package enums;


public enum SituacaoEnum {
	
	SOLICITADA("Solicitada", 1),
	RECUSADA("Recusada", 2),
	PENDENTE("Pendente", 3),
	ACEITA("Aceita",4);
	
	private final String nome;
	private final Integer codigo;
	
	private SituacaoEnum(String nome, Integer codigo) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public static SituacaoEnum getSituacaoEnum(String nome) {
		SituacaoEnum type = null;

        for (SituacaoEnum enumType : SituacaoEnum.values()) {

            if (enumType.codigo.equals(nome)) {
                type = enumType;
                break;
            }

        }

        return type;
    }
	
	public static SituacaoEnum getSituacaoEnum(Integer codigo) {
		SituacaoEnum type = null;

        for (SituacaoEnum enumType : SituacaoEnum.values()) {

            if (enumType.codigo.equals(codigo)) {
                type = enumType;
                break;
            }

        }

        return type;
    }

	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
}
