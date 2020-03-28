function varargout = untitled(varargin)
% UNTITLED MATLAB code for untitled.fig
%      UNTITLED, by itself, creates a new UNTITLED or raises the existing
%      singleton*.
%
%      H = UNTITLED returns the handle to a new UNTITLED or the handle to
%      the existing singleton*.
%
%      UNTITLED('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in UNTITLED.M with the given input arguments.
%
%      UNTITLED('Property','Value',...) creates a new UNTITLED or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before untitled_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to untitled_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help untitled

% Last Modified by GUIDE v2.5 22-Mar-2017 10:18:17

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @untitled_OpeningFcn, ...
                   'gui_OutputFcn',  @untitled_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before untitled is made visible.
function untitled_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to untitled (see VARARGIN)

% Choose default command line output for untitled
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes untitled wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = untitled_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;



function txtTamanhoPopulacao_Callback(hObject, eventdata, handles)
% hObject    handle to txtTamanhoPopulacao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtTamanhoPopulacao as text
%        str2double(get(hObject,'String')) returns contents of txtTamanhoPopulacao as a double


% --- Executes during object creation, after setting all properties.
function txtTamanhoPopulacao_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtTamanhoPopulacao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function txtNumeroGeracao_Callback(hObject, eventdata, handles)
% hObject    handle to txtNumeroGeracao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtNumeroGeracao as text
%        str2double(get(hObject,'String')) returns contents of txtNumeroGeracao as a double


% --- Executes during object creation, after setting all properties.
function txtNumeroGeracao_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtNumeroGeracao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function txtNumGenesRecombinado_Callback(hObject, eventdata, handles)
% hObject    handle to txtNumGenesRecombinado (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtNumGenesRecombinado as text
%        str2double(get(hObject,'String')) returns contents of txtNumGenesRecombinado as a double


% --- Executes during object creation, after setting all properties.
function txtNumGenesRecombinado_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtNumGenesRecombinado (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function txtTaxaRecombinacao_Callback(hObject, eventdata, handles)
% hObject    handle to txtTaxaRecombinacao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtTaxaRecombinacao as text
%        str2double(get(hObject,'String')) returns contents of txtTaxaRecombinacao as a double


% --- Executes during object creation, after setting all properties.
function txtTaxaRecombinacao_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtTaxaRecombinacao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function NumRainha_Callback(hObject, eventdata, handles)
% hObject    handle to NumRainha (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of NumRainha as text
%        str2double(get(hObject,'String')) returns contents of NumRainha as a double


% --- Executes during object creation, after setting all properties.
function NumRainha_CreateFcn(hObject, eventdata, handles)
% hObject    handle to NumRainha (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in btnIniciar.
function btnIniciar_Callback(hObject, eventdata, handles)
clc

% Definindo os parametros do algoritmo genetico

num_rainha = str2num(get(handles.txtNumRainha,'String'));               %Numero de rainhas
taxa_mut = str2num(get(handles.txtTaxaMutacao,'String'));                % Taxa de mutação
taxa_rec = str2num(get(handles.txtTaxaRecombinacao,'String'));           % Taxa de recombinação
nGenes = str2num(get(handles.txtNumGenesRecombinado,'String'));          % Número de genes recombinados
tamanhoPopulacao = str2num(get(handles.txtTamanhoPopulacao,'String'));   % Tamanho da população
nGer = str2num(get(handles.txtNumeroGeracao,'String'));                  % Número de gerações (CRITÉRIO DE PARADA)


%Gerando populacao

ger = 1;                % Primeira geração

for tamanhoPopulacao = 1:tamanhoPopulacao
   individuo(tamanhoPopulacao,:) = randperm(8); 
end

NumIndRecombinados = ceil(tamanhoPopulacao * taxa_rec); % Calcula número de indivíduos gerados por recombinação
NumIndMutados = ceil(tamanhoPopulacao * taxa_mut); % Calcula número de indivíduos gerados por mutação

%% 3 - Recombinação

for ger = 1:nGer
    
    
    
    
    
    
    

function txtTaxaMutacao_Callback(hObject, eventdata, handles)
% hObject    handle to txtTaxaMutacao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtTaxaMutacao as text
%        str2double(get(hObject,'String')) returns contents of txtTaxaMutacao as a double


% --- Executes during object creation, after setting all properties.
function txtTaxaMutacao_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtTaxaMutacao (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function txtNumeroGenes_Callback(hObject, eventdata, handles)
% hObject    handle to txtNumeroGenes (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtNumeroGenes as text
%        str2double(get(hObject,'String')) returns contents of txtNumeroGenes as a double


% --- Executes during object creation, after setting all properties.
function txtNumeroGenes_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtNumeroGenes (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end
