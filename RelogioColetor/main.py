# -*- coding: utf-8 -*-
import requests

def send_data_to_api(url, data):
    try:
        # Fazendo a requisição HTTP POST com os dados
        response = requests.post(url, json=data)

        # Verificando se a resposta foi bem-sucedida (status code 201 geralmente indica criação bem-sucedida)
        if response.status_code == 200:
            print("Dados enviados com sucesso!")
            return response.json()  # Retorna a resposta em JSON
        else:
            # print(f"Erro na requisição: {response.status_code}")
            return None
    except Exception as e:
        # print(f"Ocorreu um erro: {e}")
        return None

if __name__ == "__main__":
    # URL da API pública para o método POST
    api_url = "http://localhost:8080/leitura"

    # Dados a serem enviados (no formato JSON)
    data_to_send = {
        "pressaoArterial": "116/78",
        "temperatura": 18.2,
        "batimentoCardiaco": 120,
        "equipamento_id": 1
    }

    # Chamando a função para enviar os dados via POST
    response_data = send_data_to_api(api_url, data_to_send)

    # Exibindo a resposta se a requisição foi bem-sucedida
    if response_data:
        print("Resposta do servidor:")
        print(response_data)
