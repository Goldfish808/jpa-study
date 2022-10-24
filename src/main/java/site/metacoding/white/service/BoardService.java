package site.metacoding.white.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.board.Board;
import site.metacoding.white.domain.board.BoardRepository;
import site.metacoding.white.dto.BoardRequestDto.BoardSaveDto;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(BoardSaveDto boardSaveDto) {
        Board board = new Board();
        board.setTitle(boardSaveDto.getTitle());
        board.setContent(boardSaveDto.getContent());
        board.setUser(boardSaveDto.getServiceDto().getUser());
        // boardRepository.save(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

    @Transactional
    public void update(Long id, Board board) {
        Board boardPS = boardRepository.findById(id);
        boardPS.setTitle(board.getTitle());
        boardPS.setContent(board.getContent());
        // 트랜잭션 시 더티 체킹
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
