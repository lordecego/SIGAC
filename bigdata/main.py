# -*- coding: utf-8 -*-
import requests
import pandas as pd
import matplotlib.pyplot as plt
from pandas.plotting import register_matplotlib_converters

# Registrar conversores de datetime para evitar o aviso de FutureWarning
register_matplotlib_converters()

# URL da API
url = "http://localhost:8080/leitura/1"

# Fazendo a requisição e obtendo os dados
response = requests.get(url)

# Verificando se a requisição foi bem-sucedida
if response.status_code == 200:
    # Convertendo os dados JSON para um DataFrame do pandas
    dados = response.json()
    df = pd.DataFrame(dados)
    
    # Exibindo o DataFrame inicial
    print("Dados Recebidos:\n", df)
    
    # Separando a pressão arterial em duas colunas (sistólica e diastólica)
    df[['pressaoSistolica', 'pressaoDiastolica']] = df['pressaoArterial'].str.split('/', expand=True)
    
    # Convertendo as colunas de pressão arterial para inteiros
    df['pressaoSistolica'] = pd.to_numeric(df['pressaoSistolica'])
    df['pressaoDiastolica'] = pd.to_numeric(df['pressaoDiastolica'])
    
    # Convertendo a coluna 'dataHora' para o formato datetime
    df['dataHora'] = pd.to_datetime(df['dataHora'])
    
    # Exibindo o DataFrame atualizado
    print("\nDados Atualizados com Pressão Sistolica e Diastolica:\n", df)
    
    # Análise de temperatura
    print("\nAnálise de Temperatura:")
    print(df['temperatura'].describe())
    
    # Análise de batimentos cardíacos
    print("\nAnálise de Batimentos Cardíacos:")
    print(df['batimentoCardiaco'].describe())
    
    # Análise de pressão arterial
    print("\nAnálise de Pressão Sistólica:")
    print(df['pressaoSistolica'].describe())
    
    print("\nAnálise de Pressão Diastólica:")
    print(df['pressaoDiastolica'].describe())
    
    # Gráfico de temperatura ao longo do tempo
    plt.figure(figsize=(10, 6))
    plt.plot(df['dataHora'], df['temperatura'], marker='o', label='Temperatura')
    plt.xlabel(u'Data e Hora')
    plt.ylabel(u'Temperatura (°C)')
    plt.title(u'Variação da Temperatura ao Longo do Tempo')
    plt.grid(True)
    plt.xticks(rotation=45)
    plt.legend()
    plt.show()

    # Gráfico de batimentos cardíacos ao longo do tempo
    plt.figure(figsize=(10, 6))
    plt.plot(df['dataHora'], df['batimentoCardiaco'], marker='o', color='green', label=u'Batimentos Cardíacos')
    plt.xlabel(u'Data e Hora')
    plt.ylabel(u'Batimentos Cardíacos (bpm)')
    plt.title(u'Variação dos Batimentos Cardíacos ao Longo do Tempo')
    plt.grid(True)
    plt.xticks(rotation=45)
    plt.legend()
    plt.show()

    # Gráfico de pressão arterial (sistólica e diastólica) ao longo do tempo
    plt.figure(figsize=(10, 6))
    plt.plot(df['dataHora'], df['pressaoSistolica'], marker='o', label='Pressão Sistólica')
    plt.plot(df['dataHora'], df['pressaoDiastolica'], marker='x', label='Pressão Diastólica', color='red')
    plt.xlabel(u'Data e Hora')
    plt.ylabel(u'Pressão Arterial (mmHg)')
    plt.title(u'Variação da Pressão Arterial ao Longo do Tempo')
    plt.grid(True)
    plt.xticks(rotation=45)
    plt.legend()
    plt.show()
    
else:
    print("Erro ao buscar os dados da API:", response.status_code)
